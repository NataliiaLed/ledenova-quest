package ledenova.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ledenova.model.QuestNode;
import ledenova.service.QuestLoader;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "QuestServlet", urlPatterns = "/quests/*")
public class QuestServlet extends HttpServlet {

    private final Map<String, Map<String, QuestNode>> questsCache = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Quest ID is missing in URL");
            return;
        }

        // Extract questId from path, remove leading slash
        String questId = pathInfo.substring(1);

        Map<String, QuestNode> questNodeMap = questsCache.get(questId);
        if (questNodeMap == null) {
            try {
                questNodeMap = QuestLoader.loadQuestNodesFromYaml(questId);
                questsCache.put(questId, questNodeMap);
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Quest not found or failed to load: " + questId);
                return;
            }
        }

        String nodeId = req.getParameter("nodeId");
        if (nodeId == null || !questNodeMap.containsKey(nodeId)) {
            nodeId = "start";
        }

        QuestNode currentNode = questNodeMap.get(nodeId);
        req.setAttribute("node", currentNode);
        req.setAttribute("questId", questId);

        switch (currentNode.getType()) {
            case QUESTION:
                req.getRequestDispatcher("/WEB-INF/question.jsp").forward(req, resp);
                break;
            case WIN:
                req.getRequestDispatcher("/WEB-INF/win.jsp").forward(req, resp);
                break;
            case LOOSE:
                req.getRequestDispatcher("/WEB-INF/loose.jsp").forward(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown node type");
        }
    }
}