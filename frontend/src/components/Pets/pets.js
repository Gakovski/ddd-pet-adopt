import React from "react";

const pets = (props) => {
    return(
      <div className={"container mm-4 mt-5"}>
          <div className={"row"}>
              <div className={"row"}>
                  <table className={"table table-striped"}>
                      <thead>
                      <tr>
                          <th scope={"col"}>Pet Name</th>
                          <th scope={"col"}>Pet Type</th>
                          <th scope={"col"}>Pet Description</th>
                          <th scope={"col"}>Pet Breed</th>
                      </tr>
                      </thead>
                      <tbody>
                      {props.pets.map((term)=>{
                          return (
                              <tr>
                                  <td>{term.petName}</td>
                                  <td>{term.petTypeName}</td>
                                  <td>{term.petDescription}</td>
                                  <td>{term.petBreed}</td>
                              </tr>
                          )
                      })}
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
    );
}

export default pets;