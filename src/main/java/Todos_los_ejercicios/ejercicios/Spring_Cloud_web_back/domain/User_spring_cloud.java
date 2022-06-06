package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain;

import Todos_los_ejercicios.ejercicios.shared.StringPrefixedSequenceIdGenerator;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.userDTO.UserInputDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class User_spring_cloud {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(
            name = "ausencias_seq",
            strategy = "Todos_los_ejercicios.ejercicios.shared.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "id")
    String id;
    String user;
    String password;


    public User_spring_cloud(UserInputDto userInputDto){
        setUser(userInputDto.getUser());
        setPassword(userInputDto.getPassword());
    }

}
