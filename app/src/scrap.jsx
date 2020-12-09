import React, {Component} from 'react'
import UserRestService from '../services/UserRestService';

const validEmailRegex =
    RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i);

const validateForm = errors => {
    let valid = true;
    Object.values(errors).forEach(val => val.length > 0 && (valid = false));
    return valid;
};

class UserRegistrationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            firstName: null,
            lastName: null,
            dob: null,
            emailId: null,
            contactNumber: null,
            vehicleNumber: null,
            errors: {
                firstName: '',
                lastName: '',
                dob: '',
                emailId: '',
                contactNumber: '',
            }
        }

        this.createNewUser = this.createNewUser.bind(this);
    }

    handleChange = (event) => {
        event.preventDefault();
        const {name, value} = event.target;
        let errors = this.state.errors;

        switch (name) {
            case 'firstName':
                errors.firstName =
                    (value === '' || value === null)
                        ? 'First Name Cannot be null'
                        : '';
                break;
            case 'lastName':
                errors.lastName =
                    (value === '' || value === null)
                        ? 'Last Name Cannot be null'
                        : '';
                break;
            case 'dob':
                errors.dob =
                    (value === '' || value === null)
                        ? 'Date Of Birth Cannot be null'
                        : '';
                break;
            case 'emailId':
                errors.emailId =
                    validEmailRegex.test(value)
                        ? ''
                        : 'Email is not valid!';
                break;
            case 'contactNumber':
                errors.contactNumber =
                    value.length !== 10
                        ? 'Contact Number should be 10 digit'
                        : '';
                break;
            default:
                break;
        }

        this.setState({errors, [name]: value});
    }

    createNewUser = (event) => {
        event.preventDefault();
        if (validateForm(this.state.errors)) {
            let userDetail = {
                firstName: this.state.firstName,
                lastName: this.state.lastName,
                dob: this.state.dob,
                emailId: this.state.emailId,
                contactNumber: this.state.contactNumber,
                vehicleNumber: this.state.vehicleNumber
            };
            console.log('userDetail => ' + JSON.stringify(userDetail));

            UserRestService.checkEmailAlreadyExist(this.state.emailId).then(res => {
                this.setState({employee: res.data});
                if (res.status === 200) {
                    if (res.data === true) {
                        alert("Email already exists.")
                    } else {
                        UserRestService.createUser(userDetail);
                        this.props.history.push('/details');
                    }
                } else {
                    alert("Unexpected Error Occured")
                }
            })
        } else {
            alert("Form has errors.")
        }
    }

    cancel() {
        this.props.history.push('/');
    }

    render() {
        const {errors} = this.state;
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">New User Registration</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label> First Name: </label>
                                        <input placeholder="First Name" name="firstName" className="form-control"
                                               onChange={this.handleChange} noValidate/>
                                        {errors.firstName.length > 0 &&
                                        <span className='error'>{errors.firstName}</span>}
                                    </div>
                                    <div className="form-group">
                                        <label> Last Name: </label>
                                        <input placeholder="Last Name" name="lastName" className="form-control"
                                               onChange={this.handleChange} noValidate/>
                                        {errors.lastName.length > 0 &&
                                        <span className='error'>{errors.lastName}</span>}
                                    </div>
                                    <div className="form-group">
                                        <label> DOB: </label>
                                        <input placeholder="DOB" name="dob" className="form-control"
                                               onChange={this.handleChange} noValidate/>
                                        {errors.dob.length > 0 &&
                                        <span className='error'>{errors.dob}</span>}
                                    </div>
                                    <div className="form-group">
                                        <label> Email Id: </label>
                                        <input placeholder="Email Address" name="emailId" className="form-control"
                                               type="email" onChange={this.handleChange} noValidate/>
                                        {errors.emailId.length > 0 &&
                                        <span className='error'>{errors.emailId}</span>}
                                    </div>
                                    <div className="form-group">
                                        <label> Contact Number: </label>
                                        <input placeholder="Contact Number" name="contactNumber"
                                               className="form-control"
                                               onChange={this.handleChange} noValidate/>
                                        {errors.contactNumber.length > 0 &&
                                        <span className='error'>{errors.contactNumber}</span>}
                                    </div>
                                    <div className="form-group">
                                        <label> Vehicle Number: </label>
                                        <input placeholder="Vehicle Number" name="vehicleNumber"
                                               className="form-control"
                                               onChange={this.handleChange} noValidate/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.createNewUser} noValidate>Save
                                    </button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}
                                            style={{marginLeft: "10px"}}>Cancel
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default UserRegistrationComponent
