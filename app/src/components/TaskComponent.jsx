import React, {Component} from 'react'
import TaskService from "../services/TaskService";

const validateForm = errors => {
    let valid = true;
    Object.values(errors).forEach(val => val.length > 0 && (valid = false));
    return valid;
};

class TaskComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            tasks: [],
            name: null,
            task: null,
            desc: null,
            sol: null,
            errors: {
                name: '',
                sol: ''
            }
        };

        this.submitTask = this.submitTask.bind(this);
    }
    componentDidMount() {
        TaskService.getTasks().then((response) => {
            this.setState({tasks: response.data});
        });
    }

    handleChange = (event) => {
        event.preventDefault();
        const {name, value} = event.target;
        let errors = this.state.errors;

        switch (name) {
            case 'name':
                errors.name =
                    (value === '' || value === null)
                        ? 'Name cant be empty'
                        : '';
                break;
            case 'sol':
                errors.sol =
                    value.length < 20
                        ? 'Code cant be empty'
                        : '';
                break;
            default:
                break;
        }
        this.setState({errors, [name]: value});
    };

    submitTask = (event) => {
        event.preventDefault();
        if (validateForm(this.state.errors)) {
            let userDetail = {
                name: this.state.name,
                task: this.state.task,
                desc: this.state.desc,
                sol: this.state.sol
            };
            console.log('submission detail => ' + JSON.stringify(userDetail));
        } else {
            alert("Form has errors.")
        }
    };

    cancel() {
        this.props.history.push('/');
    }

    render() {
        let taskList = [];
        this.state.tasks.map(
            task => (taskList.push(task.name))
        );

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
                                        <input placeholder="Enter you Name" name="name" className="form-control"
                                               onChange={this.handleChange} noValidate/>
                                        {errors.name.length > 0 &&
                                        <span className='error'>{errors.name}</span>}
                                    </div>
                                    <div className="form-group">
                                        <label> Select Task: </label>
                                        <select className="form-control" id="selectTask">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </select>
                                    </div>
                                    <div className="form-group">
                                        <label> Description: </label>
                                        <input name="desc" className="form-control"/>
                                    </div>
                                    <div className="form-group">
                                        <label> Solution Code </label>
                                        <input placeholder="Paste your java code here!" name="sol" className="form-control"
                                               onChange={this.handleChange} noValidate/>
                                        {errors.sol.length > 20 &&
                                        <span className='error'>{errors.sol}</span>}
                                    </div>
                                    <button className="btn btn-success" onClick={this.submitTask} noValidate>Submit
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

export default TaskComponent
