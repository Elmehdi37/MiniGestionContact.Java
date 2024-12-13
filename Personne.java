public class Personne {

    private String nom;
    private String prenom;
    private String telephone;

    Personne(String nom,String prenom,String telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }
}
