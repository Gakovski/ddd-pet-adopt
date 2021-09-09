import React from 'react'
import { useHistory } from 'react-router'

function OrderAdd() {
    const history = useHistory()

    // setTimeout may cause an error
    setTimeout(() => {
        history.push('/pets')
    }, 4000)
    return <div>
        <img style={{"width":"100%", "height":"100%"}} src="https://cdn.dribbble.com/users/1782673/screenshots/4683964/ezgif.com-video-to-gif__2_.gif" />
        Order Successfully Submitted
    </div>
}
export default OrderAdd;