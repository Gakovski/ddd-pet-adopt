import axios from "../custom-axios/axiosOrder";
import axiosOrder from "../custom-axios/axiosOrder";
import axiosAdopter from "../custom-axios/axiosAdopter";

const OrderService = {
    fetchOrders: () => {
        return axiosOrder.get("/order");
    },

    approveOrder: (id) => {
        return axiosOrder.put(`/order/approve/${id}`)
    },

    addOrder: (adopterId, petId) => {
        //console.log("Service ",adopterId, petId)
        return axiosOrder.post("/order/added", {
            "adopterId": adopterId,
            "petId": petId
        })
    }
}

export default OrderService;