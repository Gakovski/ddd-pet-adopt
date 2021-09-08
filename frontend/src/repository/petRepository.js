import axios from "../custom-axios/axiosPet";

const PetService = {
    fetchPets: () => {
        return axios.get("/pet");
    }
}

export default PetService;