import React from 'react';
import ScoreService from "../services/ScoreService";

class ScoreComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            scores: []
        }
    }

    componentDidMount() {
        ScoreService.getScores().then((response) => {
            this.setState({scores: response.data})
        });
    }

    render() {
        return (
            <div>
                <h3 className="text-center"> Top 3 Players</h3>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <td>Name</td>
                        <td>Success Solutions</td>
                        <td>Tasks</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.scores.map(
                            score =>
                                <tr key={score.userName}>
                                    <td> {score.userName}</td>
                                    <td> {score.tasks}</td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default ScoreComponent
