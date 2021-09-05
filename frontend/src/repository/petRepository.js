import axios from "../custom-axios/axios";

const PetService = {
    fetchPets: () => {
        return axios.get("/pet");
    }
}

export default PetService;