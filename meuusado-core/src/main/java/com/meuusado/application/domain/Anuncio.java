package com.meuusado.application.domain;

import java.util.Date;
import java.util.List;

public record Anuncio(Long idAnuncio, Usuario usuario, Modelo modelo, String titulo, String descricao, int ano, float valor, Date dataCriacao, String base64ImgPrincMin, String pathImagem, List<AnuncioFotos> listAnuncioFotos) {}