package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.Prompt;

public abstract class AbstactView implements View {

    protected Prompt prompt;

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }
}
