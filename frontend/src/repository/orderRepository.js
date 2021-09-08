import axios from "../custom-axios/axiosOrder";
import axiosOrder from "../custom-axios/axiosOrder";

const OrderService = {
    fetchOrders: () => {
        return axios.get("/order");
    },

    approveOrder: (id) => {
        return axiosOrder.put(`/order/approve/${id}`)
    }
}

export default OrderService;