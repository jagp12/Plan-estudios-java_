package DBA1.Infrastructure.Controllers.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AsignacionInputDTO implements Serializable {
    private String id_persona;
    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private Date created_date,termination_date;
}
