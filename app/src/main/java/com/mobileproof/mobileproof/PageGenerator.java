package com.mobileproof.mobileproof;

/**
 * Created by Madhav on 11/1/16.
 */

public class PageGenerator {
    private String html;

    public PageGenerator(String html){
        this.html = html;
        create();
    }

    private void create(){
        html =  "<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/proof.css\">"+html;
        html = "<link href=\"https://fonts.googleapis.com/css?family=Libre+Baskerville|Open+Sans\" rel=\"stylesheet\">"+html;
        html = "<script src=\"file:///android_asset/MathJax.js\"><script/>"+html;
        html = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +html;
        html = "<html><body>" + html + "</body></html>";
    }

    public String getHtml(){
        return html;
    }



}
