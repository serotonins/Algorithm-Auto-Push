import base64

def base64_encoding(string):
    return str(base64.b64encode(string.encode('ascii')))[2:-1]


if __name__ == "__main__":
    string = input()
    print(base64_encoding(string))