package nfe114.contacts_app.contact;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// Librairie auxilliaires (id unique et valeurs remplies, voir ci-dessous)
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.UuidGenerator;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

/*
 * Classe contact permettant de créer un objet avec les propriétés basiques d'un contact commercial (nom, email, entreprise...)
 */

@Entity
// Getters et setters pour toutes les variables définies
@Getter
@Setter
// Utilisation de la bibliotheque Lombok pour simplifier l'écriture du code avec les constructeurs ci-dessous
@NoArgsConstructor
@AllArgsConstructor
// Annotation permettant de trabsmettre unique les valeurs remplies à la db
@JsonInclude(NON_DEFAULT)
// Nom de la table dans la db
@Table(name = "contacts")
public class Contact {
    // Id est la clé primaire qui sera utilisée dans la base de données
    @Id
    // Annotation permettant d'automatiser la création de clé unique
    @UuidGenerator
    // Paramètres de la table de donnée
    @Column(name = "id", unique = true, updatable = false)
    private String id;
    private String name;
    private String company;
    private String address;
    private String email;
    private String phone;
    private String status;
}