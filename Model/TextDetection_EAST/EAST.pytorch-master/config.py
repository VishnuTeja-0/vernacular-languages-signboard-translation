import os

class Config:

    image_size = [512, 512, 3]
    geometry = "QUAD" # ["RBOX", "QUAD"]
    label_method = "single" # ["single", "multiple"]
    use_formatted_data = True
    
    use_slack = True
    slack_epoch_step = 1
    slack_channel = "#updates" # "CNU04UXUN" 

    max_m_train = 12000
    data_dir = "F:\Final year project\vernacular-languages-signboard-translation\Model\Datasets\Text Detection 2"
    train_data_dir = os.path.join(data_dir, 'train')
    dev_data_dir = os.path.join(data_dir, 'dev')
    test_data_dir = os.path.join(data_dir, 'test')

    cuda = True
    lambda_score = 1
    lambda_geometry = 1
    epochs = 50
    smoothed_l1_loss_beta = 1.0
    learning_rate = 0.001
    lr_scheduler_step_size = 5000 # for every 2 epochs
    lr_scheduler_gamma = .94
    mini_batch_size = 24
    save_step = 5
    
    experiment_name = "12"
    meta_data_dir = "./experiment_meta_data" # 1
    model_dir = "./experiment_model" # epochs/save_step
    loss_dir = "./experiment_loss" # 1
    plot_dir = "./experiment_plot" # 3
    meta_data_file = os.path.join(meta_data_dir, "experiment_{}.json".format(experiment_name))
    model_file = os.path.join(model_dir, "experiment_" + experiment_name + "_epoch_{}.pth") # format during train
    loss_file = os.path.join(loss_dir, "experiment_{}.csv".format(experiment_name))
    plot_file = os.path.join(plot_dir, "experiment_" + experiment_name + "_{}.png") # format during train             

    meta_data = {"geometry":geometry,
                 "max_m_train":max_m_train,
                 "lambda_score":lambda_score,
                 "lambda_geometry":lambda_geometry,
                 "epochs":epochs, 
                 "smoothed_l1_loss_beta": smoothed_l1_loss_beta,
                 "learning_rate":learning_rate,
                 "lr_scheduler_step_size": lr_scheduler_step_size,
                 "lr_scheduler_gamma": lr_scheduler_gamma,
                 "mini_batch_size":mini_batch_size,
                 "comments": """
                 LR:0.1, 
                 Model: xavier init;
                 Score Loss:  cross entropy with beta; 
                 Geo Loss: L1 loss with text mask normalized by 8*512
                 """
                }
    
    trained_model_file = "./experiment_model/experiment_{}_epoch_{}.pth".format("11", "50") 
    eval_mini_batch_size = 16
    test_mini_batch_size = 16
    

    score_threshold = 0.7
    nms_method = "iou" # ["overlap", "iou"]
    iou_threshold = 0.05
    max_boxes = 10