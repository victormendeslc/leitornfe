package br.com.vmlc.service;

import br.com.vmlc.model.NotaFiscal;
import br.com.vmlc.model.Produto;
import br.com.vmlc.model.RazaoSocial;
import br.com.vmlc.request.PaginaRequest;
import jakarta.inject.Singleton;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Base64;
import java.util.Objects;

@Singleton
public class ConectorHttp {
    public NotaFiscal buscar(PaginaRequest nota) {

        String pagina = nota.getPagina();
        byte[] decode = Base64.getDecoder().decode(pagina);
        String html = new String(decode);
        Document doc = Jsoup.parse(html);

        Element body = doc.body();
        Elements tabelaItens = body.select("table.table-striped");

        NotaFiscal notaFiscal = new NotaFiscal();
        tabelaItens.select("tr").forEach(linha -> {
            Elements colunas = linha.select("td");
            String descricao = colunas.get(0).text();
            String quantidade = colunas.get(1).text();
            String unidade = colunas.get(2).text();
            String valorTotal = colunas.get(3).text();
            Produto produto = new Produto();
            produto.setDescricao(descricao);
            produto.setUnidade(unidade);
            produto.setQuantidade(quantidade);
            produto.setValorTotal(valorTotal);
            notaFiscal.getProdutos().add(produto);
        });

        Element accordion = body.getElementById("accordion");
        assert accordion != null;
        Element heading3 = Objects.requireNonNull(accordion.getElementById("heading3")).parent();
        assert heading3 != null;
        Elements informacoes = heading3.getElementsByTag("table");

        Elements linhas = informacoes.select("tr");
        Elements informacoesEmpresa = linhas.get(1).select("td");
        RazaoSocial razaoSocial = new RazaoSocial();
        razaoSocial.setNome(informacoesEmpresa.get(0).text());
        razaoSocial.setCnpj(informacoesEmpresa.get(1).text());
        razaoSocial.setInscricaoEstadual(informacoesEmpresa.get(2).text());
        razaoSocial.setEstado(informacoesEmpresa.get(3).text());
        notaFiscal.setRazaoSocial(razaoSocial);
        return notaFiscal;
    }
}
