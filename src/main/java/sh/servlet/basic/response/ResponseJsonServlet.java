package sh.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import sh.servlet.domain.member.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        Member member = new Member();
        member.setUsername("sunghyeon");
        member.setAge(25);

        //{"username" : "sunghyeon", "age": 25}
        String result = objectMapper.writeValueAsString(member);
        response.getWriter().write(result);

    }

}
