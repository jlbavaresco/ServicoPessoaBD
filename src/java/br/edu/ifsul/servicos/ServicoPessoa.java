package br.edu.ifsul.servicos;

import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.modelo.Pessoa;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@WebService
public class ServicoPessoa {

    @EJB
    private PessoaDAO dao;

    public ServicoPessoa() {

    }

    @WebMethod
    public List<Pessoa> listaPessoas() {
        return dao.getLista();
    }

    @WebMethod
    public Pessoa inserir(@WebParam(name = "pessoa")
            @XmlElement(required = true) Pessoa obj) {
        return dao.inserir(obj);
    }

    @WebMethod
    public Pessoa alterar(@WebParam(name = "pessoa")
            @XmlElement(required = true) Pessoa obj) {
        return dao.alterar(obj);
    }

    @WebMethod
    public boolean remover(@WebParam(name = "id")
            @XmlElement(required = true) Integer id) {
        return dao.remover(id);
    }

    private String getMensagemErro(Exception e) {
        while (e.getCause() != null) {
            e = (Exception) e;
        }
        String retorno = e.getMessage();
        return retorno;
    }

}
