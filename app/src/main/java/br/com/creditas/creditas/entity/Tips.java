package br.com.creditas.creditas.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by renan on 10/04/17.
 */

public class Tips {

    private String title;
    private String subtitle;

    public Tips(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public static List<Tips> getAll(){
        return Arrays.asList(
                new Tips("Orçamento Familiar", "Como organizar?"),
                new Tips("Controle Financeiro", "As 12 dicas de ouro"),
                new Tips("Gestão Financeira", "Aprenda a ter sergurança e tranquilidade")
        );
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


}
