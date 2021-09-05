import './App.css';
import React, {Component} from "react";
import Pets from '../Pets/pets'
import PetService from "../../repository/petRepository";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            pets: []
        }
    }

    render() {
        return (
            <div>
                <Pets pets={this.state.pets}/>
            </div>
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


    componentDidMount() {
        this.loadPets();
    }


}

export default App;
