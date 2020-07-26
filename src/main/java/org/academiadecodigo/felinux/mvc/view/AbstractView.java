package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.Prompt;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public abstract class AbstractView implements View {

    protected Prompt prompt;
    protected PrintWriter writer;

    public Prompt getPrompt() {
        return prompt;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

}
