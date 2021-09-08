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
        return axiosAdopter.post("/order", {
            "adopterId": adopterId,
            "petId": petId
        })
    }
}

export default OrderService;