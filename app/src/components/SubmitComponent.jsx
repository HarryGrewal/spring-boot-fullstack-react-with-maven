import React, {Component} from 'react'
import SubmitService from "../services/SubmitService";

const validateForm = errors => {
    let valid = true;
    Object.values(errors).forEach(val => val.length > 0 && (valid = false));
    return valid;
};

class SubmitComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            tasks: [],
            userName: '',
            program: '',
            id: '',
            taskName: '',
            description: '',
            testInput: '',
            testOutput: '',
            errors: {
                userName: '',
                program: ''
            }
        };
    }

    componentDidMount() {
        SubmitService.getTasks().then((response) => {
            console.log("checkpoint",response.data);
            this.setState({tasks: response.data});
        });
    }

    onTaskClicked = (event) => {
        this.setState({description: this.state.tasks.filter((e) => event.target.value === e.name)[0].description});
    };

    onTaskChange = (event) => {
        event.preventDefault();
        console.log(event.target.value);
        this.setState({taskName: event.target.value});

        let data = this.state.tasks.filter((e) => event.target.value === e.name);
        console.log( "this.state.taskName")
        console.log( event.target.value)
        console.log( "this.data");
        console.log(data);
        this.setState({id: data[0].id});
        this.setState({description: data[0].description});
        this.setState({testInput: data[0].testInput});
        this.setState({testOutput: data[0].testOutput});
        };


    
    submitTask = (event) => {
        event.preventDefault();
        if (validateForm(this.state.errors)) {
            let userDetail = {
                "userName": this.state.userName,
                "languageChoice": "4",
                "program": this.state.program,
                "taskId": this.state.id,
                "compilerArgs": "",
                "testInput": this.state.testInput,
                "testOutput": this.state.testOutput,
            };
            console.log('submission detail => ' + JSON.stringify(userDetail));
            SubmitService.postTask(userDetail).then(response => {
                (response.data.success === true) ? alert("Hurray! You are a Champ.") : alert(response.data.error);
            });
        } else {
            alert("Form has errors.")
        }
    };

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
                            <h3 className="text-center">Submit your Code</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label> Name: </label>
                                        <input placeholder="Enter you Name" type="text" name="userName"
                                               className="form-control"
                                               value={this.state.userName}
                                               onChange={this.handleChange}/>
                                        {errors.userName.length > 0 &&
                                        <span className='error'>{errors.userName}</span>}
                                    </div>

                                    <div className="form-group">
                                        <label> Select Task: </label>
                                        <select className="form-control" id="selectTask"
                                                value={this.state.taskName}  onClick={this.onTaskClicked} onChange={this.onTaskChange}>
                                            {this.state.tasks.map((task, key) => {
                                                return <option key={key} value={task.name}>{task.name}</option>;
                                            })}
                                        </select>
                                    </div>

                                    <div className="form-group">
                                        <label> Description: </label>
                                        <textarea name="description" className="form-control block" rows="5"
                                                  value={this.state.description} onChange={this.handleChange}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Solution Code </label>
                                        <textarea placeholder="Paste your java code here!" name="program"
                                                  className="form-control" rows="10"
                                            value={this.state.program} onChange={this.handleChange}/>
                                        {errors.program.length > 0 &&
                                        <span className='error'>{errors.program}</span>}
                                    </div>

                                    <button className="btn btn-success" onClick={this.submitTask}>Submit
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

    handleChange = (event) => {
        event.preventDefault();
        const {name, value} = event.target;
        let errors = this.state.errors;

        switch (name) {
            case 'userName':
                errors.userName =
                    (value === '' || value === null)
                        ? 'Name cant be empty'
                        : '';
                break;
            case 'program':
                errors.program =
                    value.length < 20
                        ? 'Code at least 2 lines'
                        : '';
                break;
            default:
                break;
        }
        this.setState({errors, [name]: value});
    };
}

export default SubmitComponent;
