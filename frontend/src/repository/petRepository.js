import axiosPet from "../custom-axios/axiosPet";

const PetService = {
    fetchPets: () => {
        return axiosPet.get("/pet");
    },

    addPet: (petName,petImageUrl, petDescription, petBreed) => {
        return axiosPet.post("/pet/add", {
            "petName": petName,
            "petImageUrl": petImageUrl,
            "petDescription": petDescription,
            "petBreed": petBreed
        })
    }
}

export default PetService;