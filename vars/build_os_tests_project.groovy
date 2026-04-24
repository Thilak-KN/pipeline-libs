def call() {
    sh '''
    #!/bin/bash
    cd /home/ec2/os-tests/
    git checkout master && git pull
    source /home/ec2/p3_venv/bin/activate
    pip3 install --upgrade setuptools
    pip3 install build installer
    python -m build
    pip3 uninstall -y os-tests
    python -m installer dist/*.whl
    '''
}
