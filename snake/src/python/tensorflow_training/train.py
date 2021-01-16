import numpy as np
from tensorflow.keras import Sequential
from tensorflow.keras.layers import Dense, Dropout, Conv2D, MaxPooling2D, Activation, Flatten
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.callbacks import TensorBoard
from tensorflow.keras.models import load_model
import tensorflow as tf
from collections import deque
import time
import random
from tqdm import tqdm
import os
from PIL import Image

DISCOUNT = 0.99
REPLAY_MEMORY_SIZE = 5000 # How many of the last steps to keep in memory for model training.
MIN_REPLAY_MEMORY_SIZE = 1000 # Minimum number of steps in that must be in memory before starting the training.
MINIBATCH_SIZE = 64 # The number of steps to train at once (prevents constant overfitting).
UPDATE_TARGET_EVERY = 5 # How often to update the target neural network.
MODEL_NAME = "Snake_2x256"
MAX_EPISODES = 20_000
EPSILON_DECAY = 0.99975
MIN_EPSILON = 0.001

LOAD = False # Whether or not to load the neural network model from previous save.

cur_episode = 0  
cur_epsilon = 1


