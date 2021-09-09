import React from "react";
import {useHistory} from 'react-router-dom';
import Navbar from "../../App/Navbar";
const PetAdd = (props) => {

    const History = useHistory();
    const [formData, updateFormData] = React.useState({
        petName: "",
        petImageUrl: "",
        petDescription: "",
        petBreed: ""
    })

    const HandleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const OnFormSubmit = (e) => {
        e.preventDefault();
        const petName = formData.petName;
        const petImageUrl = formData.petImageUrl;
        const petDescription = formData.petDescription;
        const petBreed = formData.petBreed;


        props.AddNewPet(petName,petImageUrl,petDescription,petBreed);
        History.push("/pets");

    }


    return(
        <div>
            <Navbar/>
            <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={OnFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="petName">Pet name</label>
                        <input type="text"
                               className="form-control"
                               id="petName"
                               name="petName"
                               required
                               placeholder="Enter pet name"
                               onChange={HandleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="petImageUrl">Pet Image Link</label>
                        <input type="text"
                               className="form-control"
                               id="petImageUrl"
                               name="petImageUrl"
                               placeholder="Upload image on imgbb.com and paste the full image link"
                               required
                               onChange={HandleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="petDescription">Pet Description</label>
                        <input type="text"
                               className="form-control"
                               id="petDescription"
                               name="petDescription"
                               placeholder="Describe the pet (Color, age etc..)"
                               required
                               onChange={HandleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="petBreed">Pet Breed</label>
                        <input type="text"
                               className="form-control"
                               id="petBreed"
                               name="petBreed"
                               placeholder="Enter pet breed"
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

export default PetAdd;