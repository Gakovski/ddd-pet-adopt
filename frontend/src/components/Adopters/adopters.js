import {useHistory, useLocation} from "react-router-dom";
import React from "react";
import Navbar from "../App/Navbar";

const Adopters = (props) => {

    const location = useLocation();
    const { data } = location.state;

    const History = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        surname: "",
        email: "",
        phone: ""
    })

    const HandleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const OnFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const surname = formData.surname;
        const email = formData.email;
        const phone = formData.phone;

        props.AddNewAdopter(name, surname, email, phone).then((ADOPTER_ID) =>{
           props.AddNewOrder(ADOPTER_ID, data)
        });


        History.push("/orders/added");

    }

    return(
        <div>
            <Navbar/>
            <div className="row mt-5">
                <div className="col-md-5">
                    <form onSubmit={OnFormSubmit}>
                        <div className="form-group">
                            <label htmlFor="name">Your Name</label>
                            <input type="text"
                                   className="form-control"
                                   id="name"
                                   name="name"
                                   required
                                   placeholder="Enter your name"
                                   onChange={HandleChange}
                            />
                        </div>

                        <div className="form-group">
                            <label htmlFor="surname">Your Surname</label>
                            <input type="text"
                                   className="form-control"
                                   id="surname"
                                   name="surname"
                                   placeholder="Enter your surname"
                                   required
                                   onChange={HandleChange}
                            />
                        </div>

                        <div className="form-group">
                            <label htmlFor="email">Your E-mail</label>
                            <input type="text"
                                   className="form-control"
                                   id="email"
                                   name="email"
                                   placeholder="Enter your e-mail"
                                   required
                                   onChange={HandleChange}
                            />
                        </div>

                        <div className="form-group">
                            <label htmlFor="phone">Your Phone Number</label>
                            <input type="text"
                                   className="form-control"
                                   id="phone"
                                   name="phone"
                                   placeholder="Enter your phone number"
                                   required
                                   onChange={HandleChange}
                            />
                        </div>

                        <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>

    )

}

export default Adopters;