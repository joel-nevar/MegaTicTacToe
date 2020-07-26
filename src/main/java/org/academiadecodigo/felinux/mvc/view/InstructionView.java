package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.felinux.mvc.view.textIO.Messages;

public class InstructionView extends AbstractView{



    @Override
    public void show() {

        super.writer.println(Messages.INSTRUCTIONS);
    }
}
