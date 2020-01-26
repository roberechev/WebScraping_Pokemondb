package miPaquete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class MiServlet
 */
@WebServlet("/MiServlet")
public class MiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url_base = "https://pokemondb.net/pokedex/all";
		ArrayList<String> pokemonCaracteristicas = new ArrayList<>();
		ArrayList<String> rutaImagenEntera = new ArrayList<>();

		try {
			Document d = Jsoup.connect(url_base).get();

			Elements lista = d.select("tr");
			Elements span = d.select("span");
			String rutarialimg = "";
			String pokemon = "";
			for (int i = 0; i < lista.size(); i++) {

				Element e = lista.get(i);
				pokemon = e.text();
				pokemonCaracteristicas.add(pokemon);
			}

			for (int i = 0; i < span.size(); i++) {
				String rutaImg = span.get(i).attr("data-src");
				if (!rutaImg.equals("")) {
					rutarialimg = rutaImg;
					rutaImagenEntera.add(rutarialimg);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("pokemonCaracteristicas", pokemonCaracteristicas);
		request.setAttribute("rutaImagenEntera", rutaImagenEntera);
		request.getRequestDispatcher("Pokemon.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
