import './App.css';
import React, {Component} from "react";
import Pets from '../Pets/pets'
import PetService from "../../repository/petRepository";
import {BrowserRouter as Router, Redirect, Route} from "react-router-dom";
import Orders from '../Orders/orders';
import OrderService from "../../repository/orderRepository";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            pets: [],
            orders: []
        }

    }
    render() {
        return (
            <Router>
                <main>
                    <div className="container">
                        <Route path={"/pets"} exact render={() => <Pets pets={this.state.pets}/>}/>
                        <Route path={"/orders"} exact render={() => <Orders orders={this.state.orders} approveOrder={this.approveOrder}/>}/>
                    </div>
                </main>
            </Router>
        );
    }
    loadPets = () => {
        PetService.fetchPets()
            .then((data)=>{
            this.setState({
                pets: data.data
            })
        });
    }

    loadOrders = () => {
        OrderService.fetchOrders()
            .then((data) =>{
                this.setState({
                    orders: data.data
                })
                data.data.map(element => {
                    console.log(element.orderId.id);
                })
            });
    }

    approveOrder = (id) => {
        OrderService.approveOrder(id)
            .then(() => {
                this.loadOrders();
            })
    }

    componentDidMount() {
        this.loadPets();
        this.loadOrders();
    }
}
export default App;
