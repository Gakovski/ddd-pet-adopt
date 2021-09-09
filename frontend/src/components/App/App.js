import './App.css';
import React, {Component} from "react";
import Pets from '../Pets/Pets'
import PetService from "../../repository/petRepository";
import {BrowserRouter as Router, Redirect, Route} from "react-router-dom";
import Orders from '../Orders/orders';
import OrderService from "../../repository/orderRepository";
import PetAdd from "../Pets/PetAdd/petAdd";
import Adopters from "../Adopters/adopters"
import AdopterService from "../../repository/adopterRepository";
import OrderAdd from "../Orders/OrderAdd/orderAdd"

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            pets: [],
            orders: [],
            adopters: [],
            adopterId: ""
        }

    }
    render() {
        return (
            <Router>
                <main>
                    <div className="container">
                        <Route path={"/orders"} exact render={() => <Orders orders={this.state.orders} approveOrder={this.approveOrder}/>}/>
                        <Route path={"/pets"} exact render={() => <Pets pets={this.state.pets}/>}/>
                        <Route path={"/pets/add"} exact render={() => <PetAdd pets={this.state.pets} AddNewPet={this.addPet}/>}/>
                        <Route path={"/adopters/add"} exact render={() => <Adopters AddNewAdopter={this.addAdopter} AddNewOrder={this.addOrder}/>}/>
                        <Route path={"/orders/added"} exact render={() => <OrderAdd AddNewOrder={this.addOrder}/>}/>
                        {/*<Redirect to={"/pets"}/>*/}
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

    addPet = (petName,petImageUrl, petDescription, petBreed) => {
        PetService.addPet(petName,petImageUrl, petDescription, petBreed)
            .then(() => {
                this.loadPets();
            });
    }

    addAdopter = async (name, surname, email, phone) => {

        const adopter = await AdopterService.addAdopter(name, surname, email, phone)
            .then(result => this.setState({
                adopterId : result.data.id.id
            }))

        return this.state.adopterId;
    }

    addOrder = (adopterID, petID) => {

        OrderService.addOrder(adopterID, petID)
            .then(() => {
                this.loadPets();
            })
    }


    loadOrders = () => {
        OrderService.fetchOrders()
            .then((data) =>{
                this.setState({
                    orders: data.data
                })
                // data.data.map(element => {
                //     //console.log(element.orderId.id);
                // })
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
