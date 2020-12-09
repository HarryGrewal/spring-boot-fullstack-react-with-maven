import React from 'react'
import {NavLink} from 'react-router-dom';

function HeaderComponent() {
    return (
        <div>
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">

                    <div className="row">
                        <div><h3 className="navbar-brand">Cognizant Challenge.</h3></div>
                        <div className="navbar-nav">
                            <li><NavLink exact
                                         to="/"
                                         activeClassName="active"
                                         className="navbar"
                            >Task</NavLink></li>
                            <li><NavLink exact
                                         to="/scores"
                                         activeClassName="active"
                                         className="navbar"
                            >Scores</NavLink></li>
                        </div>
                    </div>
                </nav>
            </header>
        </div>
    )
}

export default HeaderComponent
