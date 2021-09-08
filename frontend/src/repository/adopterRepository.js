import axiosAdopter from "../custom-axios/axiosAdopter";

const AdopterService = {

    // fetchAdopters: () => {
    //     return axiosAdopter.get("/adopter");
    // },

    addAdopter: (name, surname, email, phone) => {
        return axiosAdopter.post("/adopter/add", {
            "name": name,
            "surname": surname,
            "email": email,
            "phone": phone
        })
    }
}

export default AdopterService;