//package cz.upce.fei.inpda.druha.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureException;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class JwtFilter extends GenericFilterBean {
//
//	private String secret = "ajfn2372nf32bg28prjgergoerjerjojhep5ughrnsoeirgpo34hnpgo34ugoun4poghwp4ougn2p34uhgp984hwpfgw4ohgpw4h8pgo4hpg9whr4p9wuhpg9uw4hpg9w4hpg9hw4p9g8hwp4ghwp4hgpow4ihb3g";
//
//	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
//			throws IOException, ServletException {
//
//		final HttpServletRequest request = (HttpServletRequest) req;
//		final HttpServletResponse response = (HttpServletResponse) res;
//		final String authHeader = request.getHeader("Authorization");
//
//		if ("OPTIONS".equals(request.getMethod())) {
//			response.setStatus(HttpServletResponse.SC_OK);
//
//			chain.doFilter(req, res);
//		} else {
//
//			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//				throw new ServletException("Missing or invalid Authorization header");
//			}
//
//			final String token = authHeader.substring(7);
//
//			try {
//				final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//				request.setAttribute("claims", claims);
//			} catch (final SignatureException e) {
//				throw new ServletException("Invalid token");
//			}
//
//			chain.doFilter(req, res);
//		}
//	}
//}