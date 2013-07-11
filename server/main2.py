
from bottle import *

@route('/hello')
def hello():
    return "Hello World!"

run(host='localhost', port=8080, debug=True)






