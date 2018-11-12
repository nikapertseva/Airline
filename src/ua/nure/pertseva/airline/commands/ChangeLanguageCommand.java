package ua.nure.pertseva.airline.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Urls;

/**
 * Class for command of changing language.
 *
 * @author Pertseva Veronika
 *
 */
public class ChangeLanguageCommand extends AbstractCommand {
	/** Logger */
	private static final Logger LOGGER = Logger.getLogger(ChangeLanguageCommand.class);

	/**
	 * Method for command's executing.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 */
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response, String method)
			throws IOException {
		if (method.equals("POST")) {
			return doPost(request);
		} else {
			return Urls.ERROR_PAGE;
		}
	}

	/**
	 * Method gets parameters sendFrom and lang and sets attribute lang.
	 *
	 * @param request - request
	 * @return path to redirect
	 */
	private String doPost(HttpServletRequest request) {
		String sendFrom = request.getParameter("url");
		String lang = request.getParameter("lang");
		request.getSession().setAttribute("lang", lang);
		LOGGER.trace("Language changed to: " + lang);
		if (sendFrom.equals("")) {
			return Urls.REDIRECT_LOGIN_PAGE;
		}
		return "controller?" + sendFrom;
	}
}
