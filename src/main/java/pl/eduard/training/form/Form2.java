package pl.eduard.training.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/post2")
public class Form2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] badWords = {"stupid", "bullshit"};
        String userInput = req.getParameter("userInput");
        String userAware = req.getParameter("userAware");
        StringBuilder checkedUserInput = new StringBuilder(userInput);


        if (userAware != null) {
            resp.getWriter().write(userInput);
        } else {
            String[] userInputArray = userInput.replaceAll(",", "")
                    .replaceAll("\\.", "")
                    .split(" ");

            for (String s : userInputArray) {
                if (checkBadWord(badWords, s)) {
                    String censoringBadWord = censorship(s);
                    int firstIndexOfBadWord = checkedUserInput.indexOf(s);
                    int lastIndexOfBadWord = s.length() + firstIndexOfBadWord;

                    checkedUserInput.replace(firstIndexOfBadWord, lastIndexOfBadWord, censoringBadWord);
                }
            }

            resp.getWriter().write(checkedUserInput.toString());
        }
    }

    protected boolean checkBadWord(String[] badWordsArray, String wordToCheck) {
        for (String badWord : badWordsArray) {
            if (wordToCheck.equalsIgnoreCase(badWord)) {
                return true;
            }
        }

        return false;
    }

    protected String censorship(String toCensoring) {
        StringBuilder result = new StringBuilder();
        int lengthOfString = toCensoring.length();

        for (int i = 0; i < lengthOfString; i++) {
            result.append("*");
        }

        return result.toString();
    }
}
