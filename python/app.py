import json
import flask
import numpy


app = flask.Flask(__name__)

@app.route("/")
def index():
    """
    When you request the root path, you'll get the index.html template.

    """
    return flask.render_template("index.html")


@app.route("/data")
@app.route("/data/<int:ndata>")
def data(ndata=100):
    """
    On request, this returns a list of ``ndata`` randomly made data points.

    :param ndata: (optional)
        The number of data points to return.

    :returns data:
        A JSON string of ``ndata`` data points.

    """
    x = 10 * numpy.random.rand(ndata) - 5
    y = 0.5 * x + 0.5 * numpy.random.randn(ndata)
    A = 10. ** numpy.random.rand(ndata)
    c = numpy.random.rand(ndata)
    return json.dumps([{"_id": i, "x": x[i], "y": y[i], "area": A[i],
        "color": c[i]}
        for i in range(ndata)])


if __name__ == "__main__":
    # Set up the development server on port 8000.
    app.debug = True
    app.run(host='0.0.0.0', port=8888)
