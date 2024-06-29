package nfe114.contacts_app.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nfe114.contacts_app.contact.Contact;

import java.util.Optional;

/*
 * Cette interface permet d'exploiter les capacité du JPA repository retrouver un contact (et sa clé primaire id)
 */

@Repository
// On va utiliser les méthodes issues du JpaRepository (pour faire des opérations CRUD)
public interface ContactDatabase extends JpaRepository<Contact, String> {
    // Recherche par l'id
    Optional<Contact> findById(String id);
}