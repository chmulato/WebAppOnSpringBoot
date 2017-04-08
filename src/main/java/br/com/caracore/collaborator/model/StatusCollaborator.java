package br.com.caracore.collaborator.model;

public enum StatusCollaborator {

	PENDENTE("Pendente"), RECEBIDO("Recebido");

	private String descricao;

	StatusCollaborator(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
