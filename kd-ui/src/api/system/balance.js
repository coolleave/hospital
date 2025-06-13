import request from '@/utils/request'

// 查询液体平衡列表
export function listBalance(query) {
  return request({
    url: '/system/balance/list',
    method: 'get',
    params: query
  })
}

// 查询液体平衡详细
export function getBalance(Id) {
  return request({
    url: '/system/balance/' + Id,
    method: 'get'
  })
}

// 新增液体平衡
export function addBalance(data) {
  return request({
    url: '/system/balance',
    method: 'post',
    data: data
  })
}

// 修改液体平衡
export function updateBalance(data) {
  return request({
    url: '/system/balance',
    method: 'put',
    data: data
  })
}

// 删除液体平衡
export function delBalance(Id) {
  return request({
    url: '/system/balance/' + Id,
    method: 'delete'
  })
}

// 新增：根据 encounterId 查询生命体征
export function listBalanceByEncounterId(encounterId) {
  return request({
    url: '/system/balance/list2',
    method: 'get',
    params: { encounterId }
  })
}