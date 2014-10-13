package co.a123.a123comun.entidades;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class InfoAdicionalDetalle implements Serializable{

	public static final String ID = "_id";
    public static final String INFO_ADICIONAL = "infoAdicional";
    public static final String PREGUNTA = "pregunta";
    public static final String RESPUESTA = "respuesta";

	private static final long serialVersionUID = 1L;
	
	@DatabaseField(generatedId = true, columnName = ID)
	private long id;
	@DatabaseField(columnName = PREGUNTA)
	private String pregunta;
	@DatabaseField(columnName = RESPUESTA)
	private String respuesta;
	@DatabaseField(foreign = true, columnName = INFO_ADICIONAL)
    private InfoAdicional infoAdicional;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public InfoAdicional getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(InfoAdicional infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	
	
}
