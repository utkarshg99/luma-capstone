import requests
import json

CREDS = ('root', 'luma@123')
BASE_URL = 'http://localhost:8080'

def loadEmployee():
    data = json.load(open('Employee.json'))
    for emp in data:
        ret = requests.post(BASE_URL+"/add/employee", json= emp, auth= CREDS)
        print(ret.text)

if __name__ == "__main__":
    loadEmployee()