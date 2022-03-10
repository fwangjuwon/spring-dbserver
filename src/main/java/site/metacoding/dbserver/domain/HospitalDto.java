package site.metacoding.dbserver.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CollectionId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class HospitalDto {

    @Id
    private Integer id;

    private String addr;
    private String mgtStaDd;
    private String pcrPsblYn;
    private String ratePsblYn;
    private String recuClCd;
    private String sgguCdNm;
    private String sidoCdNm;
    private String yadmNm;
    private String ykihoEnc;
    private String xposWgs84;
    private String yposWgs84;
    private String xpos;
    private String ypos;
}
