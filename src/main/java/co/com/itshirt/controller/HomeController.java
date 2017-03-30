package co.com.itshirt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.builder.MenuBuilder;
import co.com.itshirt.domain.Usuario;
import co.com.itshirt.dto.RegistroUsuarioDTO;
import co.com.itshirt.security.CustomUserDetails;

/**
 * Controlador funcionalidades página de inicio.
 */
@Controller
public class HomeController {
	
	final static String ANONYMOUS_USER = "anonymousUser";
	
	/**
	 * Método que se encarga se ejecutar la petición raíz del proyecto, 
	 * validando si existe un usuario logueado o no, para determinar la redirección.
	 */
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model, HttpSession session) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getName().equals(ANONYMOUS_USER)) {
			CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
			final String rol = usuario.getRol().getNombre();
			session.setAttribute("nombreCompleto", usuario.getNombresCompletos());
			session.setAttribute("genero", usuario.getGenero());
			session.setAttribute("rol", rol);
			session.setAttribute("menus", MenuBuilder.obtenerMenusPorRol(usuario.getRol().getNombre()));
			return "welcome";
		} else {
			return "home";
		}
	}

}
