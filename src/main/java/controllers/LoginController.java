package controllers;

import dominio.usuario.VerificarUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginController {

	
	public static ModelAndView show(Request req, Response res){
		return new ModelAndView(null, "home/login.hbs");
	}
	
	public static ModelAndView login(Request req, Response res) {

		Map<String, String> model = new HashMap<>();
		if(!VerificarUsuario.verificar(req.queryParams("usuario"),req.queryParams("password")))
		{
			model.put("errorVerificacion","El usuario o la contrasenia son incorrectos");
			return new ModelAndView(model,"/login");
		}
		//req.session().attribute("uid", 1);
		//res.redirect("/home");
		return null;
	}
	
}
