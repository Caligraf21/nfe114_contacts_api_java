package nfe114.contacts_app.service;

import nfe114.contacts_app.contact.Contact;
import nfe114.contacts_app.database.ContactDatabase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/*
 * Classe de service qui va organiser la logique de l'application.
 * C'est ici que l'on va gérer les contacts en définissant les méthodes adaptées (createContact, getContact...).
 * Ces méthodes seront appellées quand les commerciaux cliqueront sur les boutons de fonctionnalités.
 */


@Service
//@Slf4j
// Protection en cas d'erreur, mise en place d'un rollback
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ContactService {
    // Variable pour instancier le répertoire de contacts
    private final ContactDatabase contactDatabase;

    // Retourne l'ensemble des contacts stockés dans le ContactRepo
    public Page<Contact> getAllContacts(int page, int size) {
        return contactDatabase.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    // Rechercher un contact par son id
    public Contact getContact(String id) {
        return contactDatabase.findById(id).orElseThrow(() -> new RuntimeException("Non présent dans le répertoire"));
    }
    
    // Créer un nouveau contact
    public Contact createContact(Contact contact) {
        return contactDatabase.save(contact);
    }

    // Supprimer un contact
    public void deleteContact(String id) {
        contactDatabase.deleteById(id);
    }
}