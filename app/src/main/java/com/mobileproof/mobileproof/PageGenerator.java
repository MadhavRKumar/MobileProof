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
        html = "<head>" + html;
        html =  "<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/proof.css\">"+html;
        html = "<link href=\"https://fonts.googleapis.com/css?family=Libre+Baskerville|Open+Sans\" rel=\"stylesheet\">"+html;
        html = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" + "</head>" + "<body>" + html;

        html = html +"<script type=\"text/javascript\" async\n" +
                "  src=\"https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-MML-AM_CHTML\">\n";


        String jax = "MathJax.Hub.Config({\n" +
                "         extensions: [\"tex2jax.js\",\"TeX/AMSmath.js\",\"TeX/AMSsymbols.js\"],\n" +
                "         jax: [\"input/TeX\", \"output/HTML-CSS\"],\n" +
                "         tex2jax: {\n" +
                "             inlineMath: [ ['$','$'], [\"\\\\(\",\"\\\\)\"] ],\n" +
                "             displayMath: [ ['$$','$$'], [\"\\\\[\",\"\\\\]\"] ],\n" +
                "             processEscapes: false,\n" +
                "             element: \"content\",\n" +
                "             ignoreClass: \"(tex2jax_ignore|mw-search-results|searchresults)\", /* note: this is part of a regex, check the docs! */\n" +
                "             skipTags: [\"script\",\"noscript\",\"style\",\"textarea\",\"code\"] /* removed pre as wikimedia renders math in there */\n" +
                "         },\n" +
                "         TeX: {\n" +
                "           extensions: [ \"xypic.js\",\"handle-floats.js\" ],\n" +
                "           Macros: {\n" +
                "             /* Wikipedia compatibility: these macros are used on Wikipedia */\n" +
                "             empty: '\\\\emptyset',\n" +
                "             P: '\\\\unicode{xb6}',\n" +
                "             Alpha: '\\\\unicode{x391}', /* FIXME: These capital Greeks don't show up in bold in \\boldsymbol ... */\n" +
                "             Beta: '\\\\unicode{x392}',\n" +
                "             Epsilon: '\\\\unicode{x395}',\n" +
                "             Zeta: '\\\\unicode{x396}',\n" +
                "             Eta: '\\\\unicode{x397}',\n" +
                "             Iota: '\\\\unicode{x399}',\n" +
                "             Kappa: '\\\\unicode{x39a}',\n" +
                "             Mu: '\\\\unicode{x39c}',\n" +
                "             Nu: '\\\\unicode{x39d}',\n" +
                "             Pi: '\\\\unicode{x3a0}',\n" +
                "             Rho: '\\\\unicode{x3a1}',\n" +
                "             Sigma: '\\\\unicode{x3a3}',\n" +
                "             Tau: '\\\\unicode{x3a4}',\n" +
                "             Chi: '\\\\unicode{x3a7}',\n" +
                "             C: '\\\\mathbb{C}',        /* the complex numbers */\n" +
                "             N: '\\\\mathbb{N}',        /* the natural numbers */\n" +
                "             Q: '\\\\mathbb{Q}',        /* the rational numbers */\n" +
                "             R: '\\\\mathbb{R}',        /* the real numbers */\n" +
                "             Z: '\\\\mathbb{Z}',        /* the integer numbers */\n" +
                "\n" +
                "             /* some extre macros for ease of use; these are non-standard! */\n" +
                "             F: '\\\\mathbb{F}',        /* a finite field */\n" +
                "             HH: '\\\\mathcal{H}',      /* a Hilbert space */\n" +
                "             bszero: '\\\\boldsymbol{0}', /* vector of zeros */\n" +
                "             bsone: '\\\\boldsymbol{1}',  /* vector of ones */\n" +
                "             bst: '\\\\boldsymbol{t}',    /* a vector 't' */\n" +
                "             bsv: '\\\\boldsymbol{v}',    /* a vector 'v' */\n" +
                "             bsw: '\\\\boldsymbol{w}',    /* a vector 'w' */\n" +
                "             bsx: '\\\\boldsymbol{x}',    /* a vector 'x' */\n" +
                "             bsy: '\\\\boldsymbol{y}',    /* a vector 'y' */\n" +
                "             bsz: '\\\\boldsymbol{z}',    /* a vector 'z' */\n" +
                "             bsDelta: '\\\\boldsymbol{\\\\Delta}', /* a vector '\\Delta' */\n" +
                "             E: '\\\\mathrm{e}',          /* the exponential */\n" +
                "             rd: '\\\\,\\\\mathrm{d}',      /*  roman d for use in integrals: $\\int f(x) \\rd x$ */\n" +
                "             rdelta: '\\\\,\\\\delta',      /* delta operator for use in sums */\n" +
                "             rD: '\\\\mathrm{D}',         /* differential operator D */\n" +
                "\n" +
                "             /* example from MathJax on how to define macros with parameters: */\n" +
                "             /* bold: ['{\\\\bf #1}', 1] */\n" +
                "\n" +
                "             RR: '\\\\mathbb{R}',\n" +
                "             ZZ: '\\\\mathbb{Z}',\n" +
                "             NN: '\\\\mathbb{N}',\n" +
                "             QQ: '\\\\mathbb{Q}',\n" +
                "             CC: '\\\\mathbb{C}',\n" +
                "             FF: '\\\\mathbb{F}'\n" +
                "           }\n" +
                "         }\n" +
                "     });";

        html = html + jax + "</script>";
        html = "<html>" + html + "</body></html>";
    }

    public String getHtml(){
        return html;
    }



}
